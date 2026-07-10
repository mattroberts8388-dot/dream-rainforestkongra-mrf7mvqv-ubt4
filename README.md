# Rainforest Ecosystem & Kongra

A Fabric mod for Minecraft **1.20.1** that turns the jungle into a deadly rainforest:

- **Deadly rain** — standing out in the rain (under open sky, in a rain biome) for about 10 seconds starts draining your life. Get under cover, or...
- **KONGRA armor** — a full set of KONGRA armor completely protects you from the corrosive rain. It's crafted from the hardest-to-find rainforest materials: **Cobra Scale**, **Gorilla Hide**, and **Rainforest Essence**.
- **Rainforest animals** — Jaguars and Toucans roam the world.
- **The Big Boss: KONGRA** — body of a gorilla, head of a king cobra. 300 HP, heavy armor, and a venomous bite that poisons you. Without KONGRA armor you don't stand a chance.

## How to get the mod file (.jar) — NO Java install needed!

GitHub will build the mod for you **for free** in the cloud. You never have to install Java or Gradle.

### Steps

1. **Create a GitHub account** at https://github.com (free).
2. Click the **+** in the top-right → **New repository**. Give it any name, keep it Public, and click **Create repository**.
3. On the new empty repo page, click the link **"uploading an existing file"**.
4. **Extract the ZIP** you downloaded (the one containing this mod's files) on your computer.
5. **IMPORTANT (macOS users):** The `.github` folder is **hidden by default** and Finder will NOT show it. In Finder, press **Cmd + Shift + .** (period) to reveal hidden files. If you skip this step, the build workflow will not be uploaded and **the build will never run**.
6. Open the **extracted folder**, then select **ALL files and folders INSIDE it** — including the hidden `.github` folder. **Drag the contents, not the folder itself.** (Do not drag the outer folder; drag everything that is inside it.)
7. Drag all those selected items into the GitHub upload page.
8. Scroll down and click **Commit changes**.
9. Click the **Actions** tab at the top of your repo. You'll see a build running. **Wait about 2 minutes** for the green check mark.
10. Click the finished build run, scroll to **Artifacts**, and download **mod-jar**.
11. Unzip it to get the `.jar` file. Copy that `.jar` into your `.minecraft/mods/` folder.
    - You need **Fabric Loader** and the **Fabric API** mod installed for Minecraft 1.20.1.

Launch Minecraft with the Fabric profile and enjoy the rainforest — but bring an umbrella (or KONGRA armor).

## Crafting

- **Cobra Scale**, **Gorilla Hide**, **Rainforest Essence** are the base materials (given via spawn eggs / creative for now, or drops you can add later).
- Armor recipes are shaped like vanilla armor but use the rainforest materials.

## License

MIT