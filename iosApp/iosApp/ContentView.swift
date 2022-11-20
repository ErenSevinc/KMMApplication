import SwiftUI
import shared

struct ContentView: View {
    let greeting = Greeting()
    @State var greet: String = "Eren"
    //MoviesResult?
    //= MoviesResult(
    //page: nil,
    //totalResults: nil,
    //totalPages: nil,
    //results: NSMutableArray()
    //)
    
    func load() {
        
        greeting.getPopularMovies { result, error in
            if let result = result {
                self.greet = result
            } else if let error = error {
                greet = "Error \(error)"
                
                /*MoviesResult(
                    page: nil,
                    totalResults: nil,
                    totalPages: nil,
                    results: NSMutableArray()
                )
                 
                 */
            }
        }
    }
    
    var body: some View {
        
        /*
         List{
         ForEach(greet) { item  in }
         }
         
         */
        Text(greet)
            .onAppear() {
                load()
                
            }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
