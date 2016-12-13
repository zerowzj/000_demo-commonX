for i = 0, 999, 1 do
    redis.call("INCR", "counter1")
end
