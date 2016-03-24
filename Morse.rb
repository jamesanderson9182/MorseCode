class Morse
=begin
    Created by James Anderson
    This is a Ruby version of a morse code translator that reads in text from a file and translates it
    I have used a hash map that needs reversed as that was part of the original challenge!
=end
  morse_dict = {
      "a" => ".-",
      "b" => "-...",
      "c" => "-.-.",
      "d" => "-..",
      "e" => ".",
      "f" => "..-.",
      "g" => "--.",
      "h" => "....",
      "i" => "..",
      "j" => ".---",
      "k" => "-.-",
      "l" => ".-..",
      "m" => "--",
      "n" => "-.",
      "o" => "---",
      "p" => ".--.",
      "q" => "--.-",
      "r" => ".-.",
      "s" => "...",
      "t" => "-",
      "u" => "..-",
      "v" => "...-",
      "w" => ".--",
      "x" => "-..-",
      "y" => "-.--",
      "z" => "--..",
      "1" => ".----",
      "2" => "..---",
      "3" => "...--",
      "4" => "....-",
      "5" => ".....",
      "6" => "-....",
      "7" => "--...",
      "8" => "---..",
      "9" => "----.",
      "0" => "-----",
      "." => ".-.-.-",
      "," => "--..--"
  }
  rev_morse_dict = morse_dict.invert

  the_file_to_read_from = File.open("encodedMessage.txt")
  the_encoded_message = the_file_to_read_from.readline
  the_file_to_read_from.close

  the_translation = ""

  words = the_encoded_message.split(" / ")

  words.each{ |i|
    array_of_letters = i.split(" ")
    array_of_letters.each {|j| the_translation<<(rev_morse_dict[j])}
    the_translation<<" " }
  puts "The translation is: #{the_translation.upcase}"
end