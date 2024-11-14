const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  devServer:{
    client: {
      webSocketURL: 'ws://192.168.150.26:9000/ws'
    }
  }
})
