local key = KEYS[1]

local is_exists = redis.call("EXISTS", key)
print("exist===>", is_exists)
