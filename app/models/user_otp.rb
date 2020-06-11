class UserOtp < ActiveRecord::Base
  default_scope { where(is_deleted: false) }
  belongs_to :user
  after_create :delete_all_otps
  validates_presence_of :user_id

  def generate_otp
    self.otp =rand.to_s[2..11]
    self.otp
  end

  private
  def delete_all_otps
    UserOtp.where.not(:id => self.id).where(:user_id => self.user_id).update_all(:is_deleted =>true)
  end

end
