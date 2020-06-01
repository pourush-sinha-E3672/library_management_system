class RedisClient
  attr_accessor :redis, :pool
  def initialize
     $redis_params = YAML.load_file("#{Rails.root.to_s}/config/redis.yml")

     @redis = Redis::Namespace.new("session", :redis => Redis.new(host:  $redis_params[Rails.env]["host"]))
     @pool = ConnectionPool.new(size:  $redis_params[Rails.env]["pool"], timeout: $redis_params[Rails.env]["timeout"]) {@redis}
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

