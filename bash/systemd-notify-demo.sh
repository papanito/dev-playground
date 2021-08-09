#!/bin/bash
DISPLAY=:0 DBUS_SESSION_BUS_ADDRESS=unix:path=/run/user/1000/bus notify-send --app-name=$1 $1@$(hostname) "Failed"
