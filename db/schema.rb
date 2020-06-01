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

ActiveRecord::Schema.define(version: 20200531180704) do

  create_table "book_metadatas", force: :cascade do |t|
    t.integer  "total_number",    limit: 4, default: 0, null: false
    t.integer  "total_available", limit: 4, default: 0, null: false
    t.integer  "book_id",         limit: 4,             null: false
    t.datetime "created_at",                            null: false
    t.datetime "updated_at",                            null: false
  end

  add_index "book_metadatas", ["book_id"], name: "book_id_idx", using: :btree

  create_table "book_user_associations", force: :cascade do |t|
    t.integer  "user_id",    limit: 4,   null: false
    t.integer  "book_id",    limit: 4,   null: false
    t.string   "status",     limit: 100, null: false
    t.datetime "created_at",             null: false
    t.datetime "updated_at",             null: false
  end

  add_index "book_user_associations", ["book_id", "status"], name: "book_id_status_idx", using: :btree
  add_index "book_user_associations", ["user_id", "status"], name: "user_status_idx", using: :btree

  create_table "books", force: :cascade do |t|
    t.string   "name",       limit: 255
    t.string   "author",     limit: 100
    t.string   "book_type",  limit: 100
    t.boolean  "is_deleted",             default: false
    t.datetime "created_at",                             null: false
    t.datetime "updated_at",                             null: false
  end

  add_index "books", ["author", "is_deleted"], name: "author_idx", using: :btree
  add_index "books", ["book_type", "is_deleted"], name: "book_type_idx", using: :btree
  add_index "books", ["name", "is_deleted"], name: "name_idx", using: :btree

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

  create_table "user_login_histories", force: :cascade do |t|
    t.integer  "user_id",    limit: 4,                null: false
    t.string   "action",     limit: 100, default: "", null: false
    t.datetime "action_at",                           null: false
    t.datetime "created_at",                          null: false
    t.datetime "updated_at",                          null: false
  end

  add_index "user_login_histories", ["user_id"], name: "user_id_idx", using: :btree

  create_table "user_otps", force: :cascade do |t|
    t.string   "otp",        limit: 100, default: "", null: false
    t.integer  "is_deleted", limit: 1,   default: 0,  null: false
    t.integer  "user_id",    limit: 4
    t.datetime "created_at",                          null: false
    t.datetime "updated_at",                          null: false
  end

  add_index "user_otps", ["user_id", "is_deleted"], name: "user_id_is_deleted_idx", using: :btree

  create_table "user_passwords", force: :cascade do |t|
    t.integer  "user_id",    limit: 4
    t.string   "password",   limit: 100
    t.integer  "is_active",  limit: 1,   default: 1
    t.datetime "created_at",                         null: false
    t.datetime "updated_at",                         null: false
  end

  add_index "user_passwords", ["user_id", "is_active"], name: "user_id_is_active_idx", using: :btree

  create_table "user_types", force: :cascade do |t|
    t.string   "type",       limit: 20
    t.datetime "created_at",            null: false
    t.datetime "updated_at",            null: false
  end

  add_index "user_types", ["type"], name: "type_idx", using: :btree

  create_table "users", force: :cascade do |t|
    t.string   "name",         limit: 100
    t.integer  "age",          limit: 4
    t.integer  "user_type_id", limit: 4
    t.string   "state",        limit: 100, default: "open"
    t.string   "email",        limit: 100, default: "",     null: false
    t.datetime "created_at",                                null: false
    t.datetime "updated_at",                                null: false
  end

  add_index "users", ["name"], name: "name_idx", using: :btree

end
