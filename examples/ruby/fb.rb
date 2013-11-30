require 'koala'
require 'pp'
require 'debugger'

token = "CAACEdEose0cBAJfpIDrfUheSlLYPtHFPYKLarNOzT5ipFbBCvQZBs7xZCarmF2ZC45PIZCF0XWZAZCghJdfLTEpVFn1izLoSaGVYvvQrVhfpI84PHFbr04IKuZCfyZCXgZBfeA0Gvz3a0XPWeQNZBBd7QjlqZA8absxlUrPNvCeJa5HmXEcM5QzqWIUZAmqlqrgZAKiYZD"
@graph = Koala::Facebook::API.new(token)

feed    = @graph.get_connections("me", "feed")
profile = @graph.get_object("me")
friends = @graph.get_connections("me", "friends")

my_fql_query = "SELECT movies FROM user WHERE uid in (SELECT uid2 from friend where uid1 = me())"

movies = @graph.fql_query(my_fql_query).reject{|item| item["movies"].empty?}.map(&:values)
debugger

pp "Bye"
