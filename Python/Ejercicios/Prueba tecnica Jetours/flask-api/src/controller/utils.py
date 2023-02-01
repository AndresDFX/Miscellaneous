from src.controller.exceptions import BadRequestException


def file_by_mimetype(request, mimetype):
    if 'file' not in request.files:
        raise BadRequestException({'file': 'mandatory field'})

    file = request.files['file']
    if file.mimetype != mimetype:
        raise BadRequestException({'file': 'wrong file type'})

    return file

def check_array_json(request, params):
    for p in params:
        if p not in request.get_json():
            raise BadRequestException({p: 'mandatory field'})
