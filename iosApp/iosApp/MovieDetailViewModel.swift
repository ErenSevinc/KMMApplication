//
//  MovieDetailViewModel.swift
//  iosApp
//
//  Created by Sevinc, Eren on 2.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class MovieDetailViewModel : ObservableObject {
    private let detailUseCase: GetMovieDetailUseCase = koin.getMovieDetailUseCase()
        
    @Published var movieDetailResult: MovieDetailResult = MovieDetailResult(adult: nil, backdropPath: nil, belongsToCollection: nil, budget: nil, genres: nil, homepage: nil, id: nil, imdbId: nil, originalLanguage: nil, originalTitle: nil, overview: nil, popularity: nil, posterPath: nil, productionCompanies: nil, productionCountries: nil, releaseDate: nil, revenue: nil, runtime: nil, spokenLanguages: nil, status: nil, tagline: nil, title: nil, video: nil, voteAverage: nil, voteCount: nil)
    @Published var genres: String = ""
    @Published var companies: String = ""
    
    func load(movieId: Int64) {
        detailUseCase.getMovieDetail(movieId: movieId) { result, error in
            if let result = result {
                self.movieDetailResult = result
                result.genres?.forEach { genre in
                    self.genres += "\((genre as? Genres?)??.name ?? "genre"), "
                }
                result.productionCompanies?.forEach { company in
                    self.companies += "\((company as? ProductionCompanies?)??.name ?? "company"), "
                }
            }
            else {
                /*
                self.movieResult = MoviesResult(
                    page: nil,
                    totalResults: nil,
                    totalPages: nil,
                    results: NSMutableArray()
                )
                 */
            }
        }
    }
    
}
