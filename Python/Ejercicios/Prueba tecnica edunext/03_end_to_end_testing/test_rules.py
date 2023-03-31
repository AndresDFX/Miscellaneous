"""
Testing the upgrade/downgrade rules
"""
import os
import subprocess

import pytest
import requests


NUM_ENTRIES = 3
EMPTY = len(os.listdir('../02_your_code')) <= NUM_ENTRIES


@pytest.mark.skipif(EMPTY, reason="Only run if there is a solution")
def test_upgrade_free_to_basic():
    """
    This test must run after `make data` for the customerdataapi since it relies on those fixtures.

    The test itself runs the `upgrade 49a6307e-c261-414d-86f5-c6004bcec8ab basic` and looks at the result.
    """
    _id = '49a6307e-c261-414d-86f5-c6004bcec8ab'

    subprocess.run(f'cd ../02_your_code; ./cli upgrade {_id} basic',
        shell=True, check=True,
        executable='/bin/bash')

    response = requests.get(f'http://localhost:8010/api/v1/customerdata/{_id}/')
    customer = response.json()
    assert customer['id'] == _id

    data = customer['data']
    assert data['SUBSCRIPTION'] == 'basic'
    assert "UPGRADE_DATE" in data
    assert "DOWNGRADE_DATE" not in data

    for key, value in data['ENABLED_FEATURES'].items():
        if "ENABLE_EDXNOTES" != key:
            assert value == False
        else:
            assert value == True


@pytest.mark.skipif(EMPTY, reason="Only run if there is a solution")
def test_upgrade_basic_to_premium():
    """
    This test must run after `make data` for the customerdataapi since it relies on those fixtures.

    The test itself runs the `upgrade 1b2f7b83-7b4d-441d-a210-afaa970e5b76 premium` and looks at the result.
    """
    _id = '1b2f7b83-7b4d-441d-a210-afaa970e5b76'

    subprocess.run(f'cd ../02_your_code; ./cli upgrade {_id} premium',
        shell=True, check=True,
        executable='/bin/bash')

    response = requests.get(f'http://localhost:8010/api/v1/customerdata/{_id}/')
    customer = response.json()
    assert customer['id'] == _id

    data = customer['data']
    assert data['SUBSCRIPTION'] == 'premium'
    assert "UPGRADE_DATE" in data
    assert "DOWNGRADE_DATE" not in data


@pytest.mark.skipif(EMPTY, reason="Only run if there is a solution")
def test_downgrade_premium_to_free():
    """
    This test must run after `make data` for the customerdataapi since it relies on those fixtures.

    The test itself runs the `downgrade a237ed14-88fb-45f3-b9b1-471877dbdc60 free` and looks at the result.
    """
    _id = 'a237ed14-88fb-45f3-b9b1-471877dbdc60'

    subprocess.run(f'cd ../02_your_code; ./cli downgrade {_id} free',
        shell=True, check=True,
        executable='/bin/bash')

    response = requests.get(f'http://localhost:8010/api/v1/customerdata/{_id}/')
    customer = response.json()
    assert customer['id'] == _id

    data = customer['data']
    assert data['SUBSCRIPTION'] == 'free'
    assert "DOWNGRADE_DATE" in data
    assert "UPGRADE_DATE" not in data

    for feat in data['ENABLED_FEATURES'].values():
        assert feat == False
