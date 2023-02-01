### Setup

Build Docker container in the root directory
```
docker build -t myflaskapp .    
```

Run docker container
```
docker run -p 5000:5000 myflaskapp
```

Or execute the traditional way
```
python app.py
```

The server is runing in 
```
http://127.0.0.1:5000
```

### Postman 

in the root directory there is a postman collection to more easily test the services


