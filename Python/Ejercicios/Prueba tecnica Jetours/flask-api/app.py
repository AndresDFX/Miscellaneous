import os

from flask import (
    Flask,
    g,
    jsonify,
    request
)

from src.application.exceptions import WrongFilePathException
from src.application.services import CountCapitalLettersTxtFile, BubbleSort
from src.controller.exceptions import *
from src.controller.utils import file_by_mimetype, check_array_json

app = Flask(__name__)


@app.errorhandler(BadRequestException)
@app.errorhandler(WrongFilePathException)
def handle_bad_request(error):
    response = jsonify(error.to_dict())
    response.status_code = 400
    return response


@app.route('/ordering-array', methods=['POST'])
def ordering_array():
    params = ["array"]
    check_array_json(request, params)
    json = request.get_json()
    array = json.get("array")
    repository = BubbleSort()

    if not repository.check_array_type(array):
        raise BadRequestException({'response': 'the array not contains only numbers'})

    return jsonify(repository.sort(array))


@app.route('/count-txt', methods=['GET', 'POST'])
def count_txt_file():
    if request.method == 'GET':
        return jsonify({'status': 'alive!'})
    file = file_by_mimetype(request, 'text/plain')
    repository = CountCapitalLettersTxtFile()
    count = repository.count_capital_letters(str(file.read()))
    return jsonify({'count_capital_letters': count})


if __name__ == '__main__':
    app.run(host=os.getenv('HOST', 'localhost'), port=os.getenv('PORT', '5000'))
