# using curl for api

```
curl https://api.github.com
curl -v https://api.github.com
curl -v --silent https://api.github.com/2>&1 | grep Status // just to get Status line
output=$(curl --silent -l https://api.github.com/ | head -n 1 | cut -d $'' -f2)) // to get status code
```
