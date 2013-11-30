#!/bin/env python3
# Simple Python github api example
# Like Lisnics but in Python ;)

import json
import urllib.request

BASE_URL = 'https://api.github.com/'
PATH = 'users/%s/repos'

def getUsersStats(username):
    final_url = (BASE_URL + PATH) % username
    response = urllib.request.urlopen(final_url)
    data = response.read().decode("utf-8")
    return json.loads(data)

def showUsersStats(username):
    repos = getUsersStats(username)

    for rep in repos:
        result = 'Repo: %(name)s Stars: %(stargazers_count)s Forks: %(forks_count)s' % rep
        print(result)

if __name__ == "__main__":
  showUsersStats('alisnic')
