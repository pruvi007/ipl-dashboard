import React, { Component } from 'react'
class Home extends Component{
    state = {};
    render(){
        return <div style={{color:'red'}}>
            <h1>Hello ipl-dashboard</h1>
            Continuos Integration Setup : <span style={{color:'green', fontWeight: 'bold'}}>SUCCESS</span>
            
        </div>
    }

}
export default Home;