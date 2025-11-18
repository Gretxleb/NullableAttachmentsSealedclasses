data class Photo(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val url: String
)

data class Link(
    val url: String,
    val title: String,
    val description: String,
    val photo: Photo? = null
)

sealed class Attachment(val type: String) {
    data class PhotoAttachment(val photo: Photo) : Attachment("photo")
    data class VideoAttachment(val video: Video) : Attachment("video")
    data class AudioAttachment(val audio: Audio) : Attachment("audio")
    data class DocAttachment(val doc: Doc) : Attachment("doc")
    data class LinkAttachment(val link: Link) : Attachment("link")
}
