# HTTP Server
A jank example of an implementation of HTTP client-server communication.

## Features
- [x] Can server HTTP request and response
    - [x] Can print incoming HTTP requests
    - [ ] Can parse HTTP requests
        - [ ] Parse request line (i.e. GET / HTTP/1.1)
        - [ ] Parse HTTP headers (i.e. Host: localhost:8080)
    - [ ] Can return HTTP response
        - [ ] Respond with HTML welcome page

## Usage
```bash
# Compile
./jankgradle build

# Run
./jankgradle run

# Package
./jankgradle package
```
To change port, change value in `config.properties`.