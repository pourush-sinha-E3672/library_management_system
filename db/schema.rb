# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20200524204326) do

  create_table "book_metadatas", force: :cascade do |t|
    t.integer  "total_number",    limit: 4
    t.integer  "total_available", limit: 4
    t.datetime "created_at"
    t.datetime "updated_at"
    t.integer  "book_id",         limit: 4
  end

  create_table "book_user_associations", force: :cascade do |t|
    t.integer  "user_id",    limit: 4,   null: false
    t.integer  "book_id",    limit: 4,   null: false
    t.string   "status",     limit: 100, null: false
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "book_user_associations", ["book_id", "status"], name: "book_id_status_id", using: :btree
  add_index "book_user_associations", ["user_id", "status"], name: "user_id_status_id", using: :btree

  create_table "books", force: :cascade do |t|
    t.string   "name",       limit: 255
    t.string   "author",     limit: 100
    t.string   "book_type",  limit: 100
    t.datetime "created_at"
    t.datetime "updated_at"
    t.boolean  "is_deleted",             default: false
  end

  create_table "delayed_jobs", force: :cascade do |t|
    t.integer  "priority",   limit: 4,     default: 0, null: false
    t.integer  "attempts",   limit: 4,     default: 0, null: false
    t.text     "handler",    limit: 65535,             null: false
    t.text     "last_error", limit: 65535
    t.datetime "run_at"
    t.datetime "locked_at"
    t.datetime "failed_at"
    t.string   "locked_by",  limit: 255
    t.string   "queue",      limit: 255
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "delayed_jobs", ["priority", "run_at"], name: "delayed_jobs_priority", using: :btree

  create_table "user_passwords", force: :cascade do |t|
    t.integer  "user_id",    limit: 4
    t.string   "password",   limit: 100
    t.integer  "is_active",  limit: 1,   default: 1
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "user_types", force: :cascade do |t|
    t.string   "type",       limit: 20
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "users", force: :cascade do |t|
    t.string   "name",         limit: 100
    t.string   "email",         limit: 100
    t.integer  "age",          limit: 4
    t.integer  "user_type_id", limit: 4
    t.datetime "created_at"
    t.datetime "updated_at"
    t.integer  "is_active",    limit: 1,   default: 1
  end

end
