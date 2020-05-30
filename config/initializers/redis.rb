class RedisClient
	attr_accessor :redis, :pool
  	def initialize
	   @redis = Redis::Namespace.new("session", :redis => Redis.new(host: "127.0.0.1"))
        @pool = ConnectionPool.new(size: 5, timeout: 5) {@redis}
		end

    def method_missing(method_sym, *arguments, &block)
		if @redis.respond_to? method_sym
         	pool.with do |redis_client|
                return redis_client.send(method_sym, *arguments, &block)
             end
        else
            super
        end
    end
end
 
 $redis = RedisClient.new

