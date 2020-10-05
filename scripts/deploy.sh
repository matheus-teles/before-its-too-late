#!/bin/bash

# GET FLAGS FOR ENVIRONMENT
while getopts e:v: flag
do
    case "${flag}" in
        v) version=${OPTARG};;
    esac
done

# CHECK IF VERSION HAS CORRECT VALUES
if [ "$version" != "major" ] && [ "$version" != "minor" ] && [ "$version" != "patch" ]; then
  echo "Version not valid should be: [major, minor, patch]"
  exit 1
fi

echo "Generating new $version deployment tag for Environment: $env"

# GET LAST PRODUCTION TAG
VERSION=`git describe --match "v[0-9].[0-9].[0-9]" --abbrev=0 --tags`

# GET LAST PRODUCTION VERSION FOR EACH DEPLOY TYPE
VERSION_BITS=(${VERSION//./ })
VNUM1=${VERSION_BITS[0]:1}
VNUM2=${VERSION_BITS[1]}
VNUM3=${VERSION_BITS[2]}

# UPGRADE PROPER TYPE
case "${version}" in
  major) VNUM1=$((VNUM1+1));;
  minor) VNUM2=$((VNUM2+1));;
  patch) VNUM3=$((VNUM3+1))
esac

# GENERATE NEW TAG
NEW_TAG="$VNUM1.$VNUM2.$VNUM3"

echo $NEW_TAG
