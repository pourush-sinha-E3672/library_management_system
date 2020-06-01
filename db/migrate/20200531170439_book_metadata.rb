class BookMetadata < ActiveRecord::Migration
  def self.up
    create_table :book_metadatas, force: true do |table|
      table.integer :total_number, default: 0,limit: 11, null: false
      table.integer :total_available, default: 0,limit: 11, null: false
      table.integer :book_id,                 null: false
    end
    execute "ALTER TABLE book_metadatas ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE book_metadatas ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :book_metadatas, [:book_id], name: "book_id_idx"

    execute "
	INSERT INTO `book_metadatas`(`book_id`,`total_number`, `total_available`)
	VALUES
	    (1,500,500),
	    (2,500,500),
	    (3,500,500),
	    (4,500,500),
	    (5,500,500),
	    (6,500,500),
	    (7,500,500),
	    (8,500,500),
	    (9,500,500),
	    (10,500,500),
	    (11,500,500),
	    (12,500,500),
	    (13,500,500),
	    (14,500,500),
	    (15,500,500),
	    (16,500,500),
	    (17,500,500),
	    (18,500,500)"
  end

  def self.down
    drop_table :book_metadatas
  end
end
