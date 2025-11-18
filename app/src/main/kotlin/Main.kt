fun main() {
    val service = WallService()

    val photoData = Photo(1, 123, "url_130", "url_604")
    val videoData = Video(2, 456, "Заголовок Видео", 30)
    val linkData = Link("https://example.com", "Пример", "Описание ссылки")

    val postWithAttachments = Post(
        ownerId = 1,
        fromId = 1,
        date = 1678886400,
        text = "Тестовый пост с вложениями.",
        attachments = listOf(
            Attachment.PhotoAttachment(photoData),
            Attachment.VideoAttachment(videoData),
            Attachment.LinkAttachment(linkData)
        )
    )

    val addedPost = service.add(postWithAttachments)
    println("ID поста: ${addedPost.id}")

    addedPost.attachments?.forEach { attachment ->
        when (attachment) {
            is Attachment.PhotoAttachment -> println("Фото: ${attachment.photo.photo604}")
            is Attachment.VideoAttachment -> println("Видео: ${attachment.video.title}")
            is Attachment.AudioAttachment -> println("Аудио: ${attachment.audio.artist}")
            is Attachment.DocAttachment -> println("Документ: ${attachment.doc.title}")
            is Attachment.LinkAttachment -> println("Ссылка: ${attachment.link.url}")
        }
    }
}
