class UserOtp < ActiveRecord::Base
  default_scope { where(is_deleted: false) }
  belongs_to :user

  def generate_otp
    UserOtp.where(:is_deleted =>false).update_all(:is_deleted =>true)
    self.otp =rand.to_s[2..11]
    self.save!
    self.otp
  end
end
