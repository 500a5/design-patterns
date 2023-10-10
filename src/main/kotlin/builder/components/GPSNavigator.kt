package builder.components

/**
 * Одна из фишек автомобиля.
 */
class GPSNavigator {
    private var route: String

    constructor() {
        route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London"
    }

    constructor(manualRoute: String) {
        route = manualRoute
    }
}