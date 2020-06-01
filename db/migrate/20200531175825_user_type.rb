class UserType < ActiveRecord::Migration
  def self.up
    create_table "user_types", force: :cascade do |t|
      t.string   "type",       limit: 20
    end
    execute "ALTER TABLE user_types ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE user_types ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :user_types, [:type], name: "type_idx"
    execute "INSERT INTO `user_types` (`type`)
    VALUES                                ('ADMIN'),
                                          ('STUDENT')"
  end

  def self.down
    drop_table :user_types
  end
end
