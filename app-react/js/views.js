var Header = React.createClass({
	render: function() {
		var backButton;
		if(this.props.backClick !== undefined) {
			backButton = <div className="header-btn left" onClick={this.props.backClick}>&#60; Back</div>;
		}

		return (
			<div className="header">
				{backButton}
				<h1>{this.props.title}</h1>
			</div>
		);
	}
});

var WhiskyList = React.createClass({
	getInitialState: function(){
		return {
			view: "list",
			viewItem: null
		};
	},
	itemClicked: function(item){
		console.log('Clicked: ' + item.name);
		this.setState({
			view: "detail",
			viewItem: item
		});
	},
	itemBackClicked: function(){
		this.setState({
			view: "list",
			viewItem: null
		});
	},
	render: function() {
		var self = this;

		if(this.state.view === "detail"){
			return (
				<WhiskyDetail item={this.state.viewItem} backClick={self.itemBackClicked}/>
			);	
		} else {
			var whiskyNodes = this.props.data.map(function (item) {
		      return (
		        <li className="whisky-list-item" key={item.id} onClick={self.itemClicked.bind(self,item)}>
					<div>{item.name}</div>
					<div><small>{item.subName}</small></div>
				</li>
		        );
		  	});
			return (
				<div>
					<Header title="Whisky App"></Header>
					<ul className="whisky-list">
						{whiskyNodes}
					</ul>
				</div>
			);
		}
	}
});

var WhiskyDetail = React.createClass({
	render: function() {
		return (
			<div>
				<Header title={this.props.item.name} backClick={this.props.backClick}></Header>
			</div>
		);
	}
});
