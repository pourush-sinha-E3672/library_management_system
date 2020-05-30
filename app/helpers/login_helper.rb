require 'lms_error'
module LoginHelper

  def self.validate_login(user,password)

    user = UsersHelper.get_user_details(user)
    if !user.present?
      raise LmsError.new("Invalid user #{user}",404)
    end

    if (!user.user_passwords.present? || !user.user_passwords.first.password.eql?(password))
      raise LmsError.new("Invalid password for user #{user}",404)
    end
    user
  end

  def self.start_session(user_id)
    key ="user_session_#{user_id}"
    value={}
    value["login_at"] =Time.now.to_s
    value["last_updated"] = Time.now.to_s
    $redis.setex(key, 180, value)
  end

  def self.end_session(user_id)
    key ="user_session_#{user_id}"
    $redis.del(key)
  end

end