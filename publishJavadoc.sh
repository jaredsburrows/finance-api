#!/bin/bash

SLUG="jaredsburrows/FinanceApi"
JDK="oraclejdk7"
BRANCH="master"

#set -e
set -x

if [ "$TRAVIS_REPO_SLUG" != "$SLUG" ]; then
  echo "Skipping snapshot deployment: wrong repository. Expected '$SLUG' but was '$TRAVIS_REPO_SLUG'."
elif [ "$TRAVIS_JDK_VERSION" != "$JDK" ]; then
  echo "Skipping snapshot deployment: wrong JDK. Expected '$JDK' but was '$TRAVIS_JDK_VERSION'."
elif [ "$TRAVIS_PULL_REQUEST" != "false" ]; then
  echo "Skipping snapshot deployment: was pull request."
elif [ "$TRAVIS_BRANCH" != "$BRANCH" ]; then
  echo "Skipping snapshot deployment: wrong branch. Expected '$BRANCH' but was '$TRAVIS_BRANCH'."
else

  echo -e "Publishing javadoc...\n"

  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"

  ./gradlew clean javadoc
  # remove later?
  cp -R finance-api/build/docs/javadoc $HOME/javadoc-temp
  cp -R finance-core/build/docs/javadoc $HOME/javadoc-temp
  cp -R build/docs/javadoc $HOME/javadoc-temp

  cd $HOME
  git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/jaredsburrows/FinanceApi.git gh-pages > /dev/null
  cd gh-pages
  if [ -d "./javadoc" ]; then
    git rm -rf ./javadoc
  fi
  cp -Rf $HOME/javadoc-temp ./javadoc
  git add -f .
  git commit -m "Publish Javadoc from Travis CI build $TRAVIS_BUILD_NUMBER"
  git push -fq origin gh-pages

  echo -e "Published Javadoc to gh-pages.\n"

fi
