return {
    "nvim-neo-tree/neo-tree.nvim",
    dependencies = {
        "nvim-lua/plenary.nvim",
        "nvim-tree/nvim-web-devicons",
        "MunifTanjim/nui.nvim"
    },
    cmd = "Neotree",
    keys = {
        { "<leader>e", "<CMD>Neotree toggle<CR>" }
    },
    opts = {
        window = {
            width = 32,
            mappings = {
                ["o"] = "open",
                ["<space>"] = "none",
                ["<tab>"] = "toggle_preview",
                ["oc"] = "none",
                ["od"] = "none",
                ["og"] = "none",
                ["om"] = "none",
                ["on"] = "none",
                ["os"] = "none",
                ["ot"] = "none"
            }
        },
        default_component_configs = {
            indent = {
                with_expanders = true,
                expander_collapsed = "",
                expander_expanded = "",
                expander_highlight = "NeoTreeExpander"
            }
        }
    }
}
