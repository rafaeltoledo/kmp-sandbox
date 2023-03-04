import SwiftUI

struct SubRedditScreen: View {

  @EnvironmentObject private var model: SubRedditModel

  var body: some View {
    List(model.comments) { comment in
      Text(comment.content)
    }
        .onAppear {
          Task {
            await model.loadComments()
          }
        }
  }
}
