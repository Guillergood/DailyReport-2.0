#!/usr/bin/env bash
mvn verify

bash <(curl -s https://codecov.io/bash)