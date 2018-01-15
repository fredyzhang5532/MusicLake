package com.cyl.musiclake.data.source.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.cyl.musiclake.data.model.Music;
import com.cyl.musiclake.data.model.Playlist;

public class MusicCursorWrapper extends CursorWrapper {

    public MusicCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Music getMusic() {
        Music music = new Music();
        music.setId(getString(getColumnIndex(DBData.MUSIC_ID)));
        music.setTitle(getString(getColumnIndex(DBData.MUSIC_NAME)));
        music.setArtist(getString(getColumnIndex(DBData.MUSIC_ARTIST)));
        music.setAlbum(getString(getColumnIndex(DBData.MUSIC_ALBUM)));
        music.setAlbumId(getLong(getColumnIndex(DBData.MUSIC_ALBUM_ID)));
        music.setDuration(getLong(getColumnIndex(DBData.MUSIC_TIME)));
        music.setUri(getString(getColumnIndex(DBData.MUSIC_PATH)));
        music.setCoverUri(getString(getColumnIndex(DBData.MUSIC_ALBUM_PATH)));
        music.setFileName(getString(getColumnIndex(DBData.MUSIC_FILENAME)));
        music.setFileSize(getLong(getColumnIndex(DBData.MUSIC_SIZE)));
        music.setYear(getString(getColumnIndex(DBData.MUSIC_YEARS)));
        return music;
    }

    public Playlist getPlaylist() {
        String id = getString(getColumnIndex(DBData.PLAYLIST_ID));
        String name = getString(getColumnIndex(DBData.PLAYLIST_NAME));
        int num = getInt(getColumnIndex("num"));
        return new Playlist(id, name, num);
    }

}
