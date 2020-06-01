class Book < ActiveRecord::Migration
  def self.up

    create_table "books", force: :cascade do |t|
      t.string   "name",       limit: 255
      t.string   "author",     limit: 100
      t.string   "book_type",  limit: 100
      t.boolean  "is_deleted",             default: false
    end
    execute "ALTER TABLE books ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    execute "ALTER TABLE books ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    add_index :books, [:name, :is_deleted], name: "name_idx"
    add_index :books, [:author, :is_deleted], name: "author_idx"
    add_index :books, [:book_type ,:is_deleted], name: "book_type_idx"

    execute "INSERT INTO `books` (`id`, `name`, `author`, `book_type`)
VALUES
	(1,'harry potter1', 'J. K. Rowling', 'fiction'),
	(2,'harry potter2', 'J. K. Rowling', 'fiction'),
	(3,'harry potter3', 'J. K. Rowling', 'fiction'),
	(4,'harry potter4', 'J. K. Rowling', 'fiction'),
	(5,'harry potter5', 'J. K. Rowling', 'fiction'),
	(7,'harry potter7', 'J. K. Rowling', 'fiction'),
	(6,'harry potter6', 'J. K. Rowling', 'fiction'),
	(8,'harry potter8', 'J. K. Rowling', 'fiction'),
	(9,'harry potter9', 'J. K. Rowling', 'fiction'),




	(10,'Rubb on rails', 'David Heinemeier Hansson', 'technical'),
	(11,'Java', 'James Gosling', 'technical'),
	(12,'Python', 'Guido van Rossum', 'technical'),
	(13,'C++', 'Bjarne Stroustrup', 'technical'),
	(14,'Cassandra', 'Avinash Lakshman', 'technical'),
	(15,'Batman', 'Christopher Nolan', 'comics'),
	(16,'Superman', 'Christopher Nolan', 'comics'),
	(17,'Batman vs Superman', 'Christopher Nolan', 'comics'),
	(18,'Justice league', 'Christopher Nolan', 'comics')"
  end

  def self.down
    drop_table :books
  end
end
