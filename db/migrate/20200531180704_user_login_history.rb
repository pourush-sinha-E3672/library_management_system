class UserLoginHistory < ActiveRecord::Migration
  def self.up
    create_table "user_login_histories", force: :cascade do |t|
      t.integer  "user_id",    limit: 11,                null: false
      t.string   "action",     limit: 100, default: "", null: false
    end
    execute "ALTER TABLE user_login_histories ADD action_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE user_login_histories ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE user_login_histories ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :user_login_histories, [:user_id], name: "user_id_idx"
  end

  def self.down
    drop_table :user_login_histories
  end
end
