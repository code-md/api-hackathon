#!/bin/env python
# Simple Python github api example
# Like Lisnics but in Python ;)

import json
import urllib2

BASE_URL = 'https://api.github.com/'
PATH = 'users/{}/repos'

def getUsersStats(username):
  request = urllib2.urlopen('{}{}'.format(BASE_URL, PATH.format(username)))
  data = request.read()
  return json.loads(data)

def showUsersStats(username):
	repos = getUsersStats(username)

	for rep in repos:
		print 'Repo: {} Stars: {} Forks: {}'.format(rep['name'], rep['stargazers_count'], rep['forks_count'])