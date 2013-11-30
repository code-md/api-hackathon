require 'twitter'
require 'pp'
require 'debugger'

client = Twitter::REST::Client.new do |config|
  config.consumer_key        = "iDCEPA0409lzVJIur4BQPw"
  config.consumer_secret     = "2nsEiHTWGONrdfjsJAIVjm7Z6qkSlkUgOnLN9HxIeg"
  config.access_token        = "2220919940-Eh1A1agXBunZZenrqQaIuyRPak8d9BLDtvILp54"
  config.access_token_secret = "vIgMxkoXRemM7hAnFSt3Gz42rg8MlJy0JfPgDwUjCYRPH"
end

client.search 'jigurda'
debugger

pp "Bye"


