#!/usr/bin/python
import wincertstore
import atexit
import ssl

certfile = wincertstore.CertFile()
certfile.addstore("CA")
certfile.addstore("ROOT")
atexit.register(certfile.close) # cleanup and remove files on shutdown)

ssl_sock = ssl.wrap_socket(sock,
                           ca_certs=certfile.name,
                           cert_reqs=ssl.CERT_REQUIRED)
