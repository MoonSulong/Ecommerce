var app = angular.module("myapp", []).controller(
		"myController",
		function($scope, $http) {

			var BASE_PATH = "http://localhost:8088/onlineShop";

			$scope.getProductList = function() {
				$http.get(BASE_PATH + "/getProductsList")
						.success(function(data) {
							$scope.products = data;
						});
			}

			$scope.addToCart = function(productId) {
				$http.put(BASE_PATH + "/cart/add/" + productId)
						.success(function() {
							alert("Added Successfully");
						})
			}

			$scope.refreshCart = function() {
				$http.get(BASE_PATH + "/cart/getCart/"
								+ $scope.cartId).success(function(data) {

					$scope.carts = data;
				})
			}

			$scope.getCart = function(cartId) {
				$scope.cartId = cartId;
				$scope.refreshCart(cartId);
			}
			
			$scope.removeFromCart = function(cartItemId) {
				$http.delete(BASE_PATH +"/cart/removeCartItem/"
								+ cartItemId).success(function() {
					$scope.refreshCart();
				});
			}

			$scope.clearCart = function() {
				$http.delete(BASE_PATH + "/cart/removeAllItems/"
								+ $scope.cartId).success(function() {
					$scope.refreshCart();
				});
			}

			$scope.calculateTotal = function() {
				var total = 0.0;
				for (var i = 0; i < $scope.carts.cartItem.length; i++)
					total = total + $scope.carts.cartItem[i].price;
				return total;

			}
		});
