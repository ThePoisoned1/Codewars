import re
def song_decoder(song):
    return re.sub(' +', ' ', song.replace("WUB", " ").strip())
