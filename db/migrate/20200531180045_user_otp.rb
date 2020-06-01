class UserOtp < ActiveRecord::Migration
  def self.up
    create_table "user_otps", force: :cascade do |t|
      t.string   "otp",        limit: 100, default: "", null: false
      t.integer  "is_deleted", limit: 1,   default: 0,  null: false
      t.integer  "user_id",    limit: 11
    end
    execute "ALTER TABLE user_otps ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE user_otps ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :user_otps, [:user_id,:is_deleted], name: "user_id_is_deleted_idx"
  end

  def self.down
    drop_table :user_otps
  end
end
