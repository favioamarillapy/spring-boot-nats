import { connect, StringCodec } from "nats.ws";

function App() {

  function addEntry(s) {
    const p = document.createElement("pre");
    p.appendChild(document.createTextNode(s));
    document.getElementById("messages").appendChild(p);
  }

  const init = async function () {
    try {
      const nc = await connect({ servers: "ws://localhost:443" });
      addEntry('NATS status: CONNECTED');

      const sc = StringCodec();

      const sub = nc.subscribe("example");
      (async () => {
        for await (const m of sub) {
          addEntry(`Message reived from backaend [${sub.getProcessed()}]: ${sc.decode(m.data)}`);
        }
      })();

    } catch (err) {
      console.log(`error connecting to nats: `, err);
    }
  }

  init();


  return (
    <div style={{ textAlign: "center" }}>
      <div id="messages" className="container"></div>
    </div>
  )
}

export default App
