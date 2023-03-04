import SwiftUI

@MainActor
class SubRedditModel: ObservableObject {

  @Published var comments: [Comment] = []

  func loadComments() async {
    comments = [
      Comment(content: """
                       Dave Grohl showed up with no publicity to cook and serve for 500 people at Hope Mission
                       in L.A.
                       """),
      Comment(content: "When people make fun of me watching twitch I show them this..."),
      Comment(content: "Finland begins building $597 million barbed wire fence on Russian border"),
      Comment(content: "Florida Republicans introduce a bill to eliminate the Democratic Party."),
      Comment(content: "Triple bacon - Day 99"),
      Comment(content: """
                       Amy Coney Barrett joins liberal Supreme Court justices in scrutinizing a student-loan
                       company's involvement in one of the lawsuits blocking Biden's debt relief
                       """),
      Comment(content: """
                       TIL that “Stranger Things” star Winona Ryder pushed for Kate Bush’s song “Running Up
                       That Hill” to be featured on the show. Ryder also stated that for seven years, she dropped
                       hints on the show’s set by wearing her Kate Bush t-shirts. Winona’s plan eventually worked.
                       """),
      Comment(content: "Born today. Both parents are white as snow."),
      Comment(content: "This Japanese restaurant has a waxwork samurai in the urinals"),
      Comment(content: "to get a snack"),
      Comment(content: "Brendan Fraser posing with his SAG award. Taken from his IG."),
      Comment(content: "Starbucks told us there were no pup cups today. (OC)."),
      Comment(content: """
                       This man has nurtured a turtle with an exposed heart to ensure she survives and thrives
                       (3:31)
                       """),
      Comment(content: "Dave Grohl spent 16 hours in a storm BBQing for the homeless in LA"),
      Comment(content: "me irl"),
      Comment(content: "Woman is detained for wearing a bikini on a beach")
    ]
  }
}

struct Comment: Identifiable {
  var id = UUID()
  var content: String
}
