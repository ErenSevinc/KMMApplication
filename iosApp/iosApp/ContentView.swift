import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel = MoviesViewModel()
    //let greeting = Greeting()
    //@State var greet: String = "Eren"

    let layout = [
        GridItem(.flexible()),
        GridItem(.flexible())
    ]
    
    var body: some View {
        NavigationView {
            ScrollView {
                LazyVGrid(columns: layout, spacing: 5) {
                    ForEach(viewModel.movieItemList, id: \.self) { item in
                        NavigationLink(destination: MovieDetailView(movieId: item.id as? Int64)){
                        MovieCard(item: item)
                        }
                        .navigationBarTitle("Popüler Filmler", displayMode: .inline)
                        .buttonStyle(.plain)
                    }
                }
            }
        }
    }
}

struct MovieCard: View {
    let item: MovieItem
    var body: some View {
        VStack {
            VStack {
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string: "https://www.themoviedb.org/t/p/w220_and_h330_face/\(item.posterPath ?? "pFlaoHTZeyNkG83vxsAJiGzfSsa.jpg")")) { image in
                        image
                            .resizable()
                            .scaledToFit()
                            .frame(width: .infinity, height:330)
                    } placeholder: {
                        Image("placeholder")
                            .resizable()
                            .scaledToFit()
                            .frame(width: .infinity, height:330)
                    }
                } else {
                    // Fallback on earlier versions
                }
            }
            VStack {
                Text("Film")
                Text("\(item.title ?? "Boş")").font(.system(size:12)).multilineTextAlignment(.center)
            }
            Spacer(minLength: 10)
        }.background(Color(UIColor(named: "Begie")!)).cornerRadius(20)
    }


    struct ContentView_Previews: PreviewProvider {
        static var previews: some View {
            ContentView()
        }
    }
}
