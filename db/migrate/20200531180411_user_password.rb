class UserPassword < ActiveRecord::Migration
  def self.up
    create_table "user_passwords", force: :cascade do |t|
      t.integer  "user_id",    limit: 11
      t.string   "password",   limit: 100
      t.integer  "is_active",  limit: 1,   default: 1
    end
    execute "ALTER TABLE user_passwords ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE user_passwords ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :user_passwords, [:user_id ,:is_active], name: "user_id_is_active_idx"
  end

  def self.down
    drop_table :user_passwords
  end
end
