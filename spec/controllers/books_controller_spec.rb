require 'rails_helper'

RSpec.describe BooksController, type: :controller do
  context 'Get Book list' do
    it 'returns a success response'
    post :list_books
    expect(response).to be_success

  end
end