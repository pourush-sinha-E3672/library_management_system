class User < ActiveRecord::Migration
  def self.up
    create_table "users", force: :cascade do |t|
      t.string   "name",         limit: 100
      t.integer  "age",          limit: 4
      t.integer  "user_type_id", limit: 4
      t.string   "state",        limit: 100, default: "open"
      t.string   "email",        limit: 100, default: "",     null: false
    end
    execute "ALTER TABLE users ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE users ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :users, [:name], name: "name_idx"

  end
  def self.down
    drop_table :users
  end
end
