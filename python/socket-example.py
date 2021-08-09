#!/usr/bin/python

# Client socket example with default context and IPv4/IPv6 dual stack:
# https://docs.python.org/3/library/ssl.html
import socket
import ssl

hostname = 'wyssmann.com'
context = ssl.create_default_context()

with socket.create_connection((hostname, 443)) as sock:
    with context.wrap_socket(sock, server_hostname=hostname) as ssock:
        print(ssock.version())
