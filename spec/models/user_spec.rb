require 'rails_helper'

RSpec.describe User, type: :model do
  pending "add some examples to (or delete) #{__FILE__}"
  context "User validation test" do
    it "ensure email formats" do
      user = User.new
      user.name ="pourush"
      user.email="poiududu"
      user.age =34
      user.user_type_id = 2
      expect(user.valid?).to eq(false)
    end
    it "ensure user name  uniqumess" do
      user = User.new
      user.name ="pourush"
      user.email="pourush.sinha@gmail.com"
      user.age =34
      user.user_type_id = 2
      user.save!
      user = User.new
      user.name ="pourush"
      user.email="pourush.sinha@gmail.com"
      user.age =34
      user.user_type_id = 2

      expect(user.valid?).to eq(false)
    end
  end
end
