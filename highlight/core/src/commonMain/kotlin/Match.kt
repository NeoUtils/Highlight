data class Match(
    val index: Int,
    val range: IntRange,
    val text: String,
    val groups: List<Group?>
) {

    constructor(
        index: Int,
        match: MatchResult
    ) : this(
        index = index,
        range = match.range,
        text = match.value,
        groups = match.groups.map {
            it?.let {
                Group(
                    text = it.value,
                    range = IntRange.EMPTY // TODO: improve later
                )
            }
        }
    )

    data class Group(
        val text: String,
        val range: IntRange
    )
}