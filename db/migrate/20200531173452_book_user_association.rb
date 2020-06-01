class BookUserAssociation < ActiveRecord::Migration
  def self.up
    create_table "book_user_associations", force: :cascade do |t|
      t.integer  "user_id",    limit: 11,   null: false
      t.integer  "book_id",    limit: 11,   null: false
      t.string   "status",     limit: 100, null: false
    end
    execute "ALTER TABLE book_user_associations ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE book_user_associations ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :book_user_associations, [:book_id,:status], name: "book_id_status_idx"
    add_index :book_user_associations, [:user_id,:status], name: "user_status_idx"
  end

  def self.down
    drop_table "book_user_associations"
  end
end
