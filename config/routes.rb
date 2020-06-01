Rails.application.routes.draw do
  # The priority is based upon order of creation: first created -> highest priority.
  # See how all your routes lay out with "rake routes".

  # You can have the root of your site routed with "root"
  # root 'welcome#index'

  # Example of regular route:
  #   get 'products/:id' => 'catalog#view'

  # Example of named route that can be invoked with purchase_url(id: product.id)
  #   get 'products/:id/purchase' => 'catalog#purchase', as: :purchase

  # Example resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Example resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Example resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Example resource route with more complex sub-resources:
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', on: :collection
  #     end
  #   end

  # Example resource route with concerns:
  #   concern :toggleable do
  #     post 'toggle'
  #   end
  #   resources :posts, concerns: :toggleable
  #   resources :photos, concerns: :toggleable

  # Example resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end
  root 'login#home'
  post 'login' ,to: "login#login"
  get 'sign_up' ,to: "login#sign_up"
  get 'sign_up/otp' ,to: "login#otp"
  post 'sign_up/verify_otp/:id' ,to: "users#verify_otp" ,as: 'sign_up_verify_otp'
  put 'logout/:id' ,to: "login#logout", as:'logout'
  post 'user/create' ,to: "users#create_user"
  match  'list_books' ,to: "books#list" ,via: [:get ,:post]
  get  'book_details/:id' ,to: "books#show" ,as: 'book_details'
  get  'book/edit/:id' ,to: "books#edit" ,as: 'book_edit'
  post 'book/update/:id' ,to: "books#update" ,as: 'book_update'
  put  'book/delete/:id' ,to: 'books#delete' ,as: 'delete_book'
  post 'book/issue' ,to: 'book_user_association#associate_user_with_book'
  post 'book/return' ,to: 'book_user_association#dissociate_user_with_book'
  get  'book/:id/user_list' ,to: "books#user_list" ,as: 'book_user_list'
  post 'book/add' ,to: "books#add" ,as: 'book_add'
  post 'book/add_book' ,to: "books#add_book" ,as: 'add_book'
  require 'sidekiq/web'
  mount Sidekiq::Web =>"/sidekiq"
end
